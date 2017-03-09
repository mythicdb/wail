import '../../../wailPollyfil'
import { remote, ipcRenderer as ipc } from 'electron'
import ArchiveManager from '../../../wail-core/managers/archiveManager'

const archiveMan = window.am = new ArchiveManager(remote.getGlobal('settings'))

ipc.on('made-heritrix-jobconf', (event, confDetails) => {
  console.log('archive man makeHeritrixJobConf', confDetails)
  if (!confDetails.wasError) {
    archiveMan.addCrawlInfo(confDetails)
      .then(updated => {
        console.log(`archive man updated`, updated)
        ipc.send('crawl-to-collection', updated)
      })
      .catch(error => {
        console.log('update archiveMan failed', error)
        ipc.send('display-message', error.m)
      })
  }
})

ipc.on('get-all-collections', (event) => {
  console.log('archiveman got get-all-collections')
  archiveMan.getAllCollections()
    .then(cols => {
      ipc.send('got-all-collections', {
        wasError: false,
        cols
      })
    })
    .catch(err => {
      ipc.send('got-all-collections', {
        wasError: true,
        err
      })
    })
})

ipc.on('add-multi-warcs-to-col', (event, multi) => {
  archiveMan.addMultiWarcToCol(multi)
    .then(update => {
      ipc.send('added-warcs-to-col', update)
    })
    .catch(error => {
      ipc.send('display-message', error.m)
    })
})

ipc.on('addfs-warcs-to-col', (event, fsAdd) => {
  console.log('archives got addfs warcs', fsAdd)
  archiveMan.addWarcsFromFSToCol(fsAdd)
    .then(update => {
      ipc.send('added-warcs-to-col', update)
      ipc.send('display-message', {
        title: 'Added (W)arc file from the file system',
        level: 'success',
        autoDismiss: 10,
        message: `Add to the collection ${fsAdd.col}`,
        uid: `Add to the collection ${fsAdd.col}`
      })
    })
    .catch(error => {
      ipc.send('display-message', error.m)
    })
})

ipc.on('add-metadata-to-col', (event, addMe) => {
  let {forCol, mdata} = addMe
  archiveMan.addMetadata(forCol, mdata)
    .then(numUpdate => {
      ipc.send('added-metadata-to-col', {
        wasError: false,
        numUpdate
      })
    })
    .catch(error => {
      ipc.send('added-metadata-to-col', {
        wasError: true,
        error
      })
    })
})

ipc.on('add-warcs-to-col', (event, addMe) => {
  console.log('archive man got add warcs to col', addMe)
  archiveMan.addWarcsToCol(addMe)
    .then(update => {
      ipc.send('added-warcs-to-col', update)
    })
    .catch(error => {
      ipc.send('display-message', error.m)
    })
})

ipc.on('add-warcs-to-col-wcreate', (event, addMe) => {
  console.log('archive man got add warcs to col', addMe)
  archiveMan.addWarcsFromWCreate(addMe)
    .then(update => {
      ipc.send('added-warcs-to-col', update)
      let message
      if (addMe.type && addMe.type === 'twitter') {
        message = `Saved one tweet for the collection ${addMe.col}`
      } else {
        message = `WARC was added to the collection ${addMe.col}`
      }
      ipc.send('display-message', {
        title: 'Page only crawl finished',
        level: 'success',
        autoDismiss: 10,
        message,
        uid: message
      })
    })
    .catch(error => {
      ipc.send('display-message', error.m)
    })
})

ipc.on('create-collection', (event, nc) => {
  let {mdata} = nc
  archiveMan.createCollection(nc)
    .then((newCol) => {
      console.log('archiveman really did create the new collection', newCol)
      ipc.send('created-collection', newCol)
      return archiveMan.addInitialMData(nc.col, mdata)
        .then(() => {
          console.log('mdata was successfully added')
          ipc.send('display-message', {
            title: 'Info',
            level: 'info',
            message: `Added metadata for ${nc.col}`,
            uid: `Added metadata for ${nc.col}`
          })
        })
        .catch(error => {
          ipc.send('display-message', {
            title: 'Error',
            level: 'error',
            autoDismiss: 0,
            message: `Pywb was unable to add metadata for ${nc.col} because ${error}`,
            uid: `Pywb was unable to add metadata for ${nc.col} because ${error}`
          })
        })
    })
    .catch((error) => {
      console.error(error)
      ipc.send('display-message', {
        title: 'Error',
        level: 'error',
        autoDismiss: 0,
        message: `Creating new collection ${nc.col} for ${error}`,
        uid: `Creating new collection ${nc.col} for ${error}`
      })
    })
})

ipc.on('update-metadata', (e, update) => {
  console.log('archive man got update-metadata', update)
  archiveMan.updateMetadata(update)
    .then(updated => ipc.send('updated-metadata', {wasError: false, forCol: update.forCol, mdata: updated}))
    .catch(error => ipc.send('updated-metadata', {wasError: true, error, forCol: update.forCol}))
})

archiveMan.initialLoad()
  .then((loaded) => {
    console.log('archive man inital load')
    ipc.send('archiveMan-initial-load', {
      cols: loaded,
      wasError: false
    })
  })
  .catch(error => {
    ipc.send('archiveMan-initial-load-failed', error)
  })