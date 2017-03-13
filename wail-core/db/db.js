import DB from 'nedb'
import path from 'path'
import Promise from 'bluebird'
import * as dbErrors from './dbErrors'

export default class Db {
  constructor (opts, dbBasePath) {
    this.humanName = opts.dbHumanName || path.basename(opts.filename, '.db')
    if (opts.dbHumanName) {
      delete opts.dbHumanName
    }
    this.db = new DB(opts)
    this.filePath = opts.filename
    this.dbBasePath = dbBasePath
  }

  loadDb () {
    return new Promise((resolve, reject) => {
      this.db.loadDatabase(err => {
        if (err) {
          reject(new dbErrors.LoadError(err))
        } else {
          resolve()
        }
      })
    })
  }

  clearDb () {
    return this.remove({}, {multi: true})
  }

  count (what) {
    return new Promise((resolve, reject) => {
      this.db.count(what, (err, count) => {
        if (err) {
          reject(new dbErrors.CountError(err))
        } else {
          resolve(count)
        }
      })
    })
  }

  find (query) {
    return new Promise((resolve, reject) => {
      this.db.find(query, (err, docs) => {
        if (err) {
          reject(new dbErrors.FindError(err))
        } else {
          resolve(docs)
        }
      })
    })
  }

  findAll () {
    return this.find({})
  }

  findAllApplyFun (fun) {
    return this.find({}).then(all => fun(all))
  }

  _find (query) {
    return new Promise((resolve, reject) => {
      this.db.find(query, (err, docs) => {
        if (err) {
          resolve({wasError: true, err})
        } else {
          resolve({wasError: false, docs})
        }
      })
    })
  }

  async findAndUpdateOrInsert (find, update, insert) {
    let findRet = await this._findOne(find.q)
    if (!findRet.wasError) {
      if (find.doUpdate(findRet.doc)) {
        let updateRet = await this._update(update.who, update.theUpdate, update.opts)
        if (updateRet.wasError) {
          throw new dbErrors.FindAndUpdateOrInsertError(updateRet.err, 'update after find')
        }
      } else {
        let insertRet = await this._insert(insert)
        if (!insertRet.wasError) {
          return insertRet.docs
        } else {
          throw new dbErrors.FindAndUpdateOrInsertError(insertRet.err, 'creating')
        }
      }
    } else {
      throw new dbErrors.FindAndUpdateOrInsertError(findRet.err, 'finding')
    }
  }

  async findAndUpdateOrInsertThenFindAll (find, update, findAll, insert) {
    let findRet = await this._findOne(find.q)
    if (!findRet.wasError) {
      if (find.doUpdate(findRet.doc)) {
        let updateRet = await this._update(update.who, update.theUpdate, update.opts)
        if (!updateRet.wasError) {
          let findAllRet = await this._find(findAll)
          if (!findAllRet.wasError) {
            return findAllRet.docs
          } else {
            throw new dbErrors.FindAndUpdateOrInsertThenFindAllError(findAllRet.err, 'find all after find and update')
          }
        } else {
          throw new dbErrors.FindAndUpdateOrInsertThenFindAllError(updateRet.err, 'update after find')
        }
      } else {
        let insertRet = await this._insert(insert)
        if (!insertRet.wasError) {
          let findAllRet = await this._find(findAll)
          if (!findAllRet.wasError) {
            return findAllRet.docs
          } else {
            throw new dbErrors.FindAndUpdateOrInsertThenFindAllError(findAllRet.err, 'find all after insert')
          }
        } else {
          throw new dbErrors.FindAndUpdateOrInsertThenFindAllError(insertRet.err, 'creating')
        }
      }
    } else {
      throw new dbErrors.FindAndUpdateOrInsertThenFindAllError(findRet.err, 'finding')
    }
  }

  findOne (query) {
    return new Promise((resolve, reject) => {
      this.db.findOne(query, (err, doc) => {
        if (err) {
          reject(new dbErrors.FindOneError(err))
        } else {
          resolve(doc)
        }
      })
    })
  }

  _findOne (query) {
    return new Promise((resolve, reject) => {
      this.db.findOne(query, (err, doc) => {
        if (err) {
          resolve({wasError: true, err})
        } else {
          resolve({wasError: false, doc})
        }
      })
    })
  }

  findOneSelect (query, select) {
    return new Promise((resolve, reject) => {
      this.db.findOne(query, select, (err, docs) => {
        if (err) {
          reject(new dbErrors.FindOneSelectError(err))
        } else {
          resolve(docs)
        }
      })
    })
  }

  insert (insertMe) {
    return new Promise((resolve, reject) => {
      this.db.insert(insertMe, (err, docs) => {
        if (err) {
          reject(new dbErrors.InsertError(err))
        } else {
          resolve(docs)
        }
      })
    })
  }

  _insert (insertMe) {
    return new Promise((resolve, reject) => {
      this.db.insert(insertMe, (err, docs) => {
        if (err) {
          resolve({wasError: true, err})
        } else {
          resolve({wasError: false, docs})
        }
      })
    })
  }

  async insertFindAll (insertMe, findQ) {
    let insertRet = await this._insert(insertMe)
    if (!insertRet.wasError) {
      let findAllRet = await this._find(findQ)
      if (!findAllRet.wasError) {
        return findAllRet.docs
      } else {
        throw new dbErrors.InsertFindAllError(findAllRet.err, 'find all after insert')
      }
    } else {
      throw new dbErrors.InsertFindAllError(insertRet.err, 'creating')
    }
  }

  remove (query, opts = {}) {
    return new Promise((resolve, reject) => {
      this.db.remove(query, opts, (err, rmc) => {
        if (err) {
          reject(new dbErrors.RemoveError(err))
        } else {
          resolve(rmc)
        }
      })
    })
  }

  update (updateWho, theUpdate, opts = {}) {
    return new Promise((resolve, reject) => {
      this.db.update(updateWho, theUpdate, opts, (err, numAffected, affectedDocuments, upsert) => {
        if (err) {
          reject(new dbErrors.UpdateError(err))
        } else {
          resolve(affectedDocuments)
        }
      })
    })
  }

  _update (updateWho, theUpdate, opts = {}) {
    return new Promise((resolve, reject) => {
      this.db.update(updateWho, theUpdate, opts, (err, numAffected, affectedDocuments, upsert) => {
        if (err) {
          resolve({wasError: false, err})
        } else {
          resolve({wasError: false})
        }
      })
    })
  }

  async updateFindAll (updateWho, theUpdate, upOpts, findQ) {
    let updateRet = await this._update(updateWho, theUpdate, upOpts)
    if (!updateRet.wasError) {
      let findAllRet = await this._find(findQ)
      if (!findAllRet.wasError) {
        return findAllRet.docs
      } else {
        throw new dbErrors.UpdateFindAllError(findAllRet.err, 'find all after update')
      }
    } else {
      throw new dbErrors.UpdateFindAllError(updateRet.err, 'update')
    }
  }
}