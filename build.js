const pug = require('pug')
const path = require('path')
const fs = require('fs-extra')

const here = process.cwd()

const version = '1.0.2'
const wailHomeOpts = {
  youtubelink: 'https://www.youtube.com/embed/xAovJNO08OI',
  wikilink: 'https://github.com/N0taN3rd/wail/wiki',
  macosdl: `https://github.com/N0taN3rd/wail/releases/download/${version}/WAIL.dmg`,
  linuxdl: `https://github.com/N0taN3rd/wail/releases/download/${version}/WAIL-linux-x64.zip`,
  windowsdl: `https://github.com/N0taN3rd/wail/releases/download/${version}/WAIL-win32-x64.zip`,
  projectHome: 'https://github.com/N0taN3rd/wail',
  hd516:'https://securegrants.neh.gov/publicquery/main.aspx?f=1&gn=HD-51670-13',
  hd501:'https://securegrants.neh.gov/publicquery/main.aspx?f=1&gn=HK-50181-14',
  neh:'https://www.neh.gov/',
}

const compiledFunction = pug.compileFile(path.join(here, 'pug', 'index.pug'), {pretty: true})

fs.writeFileSync(path.join(here, 'index.html'), compiledFunction(wailHomeOpts), 'utf8')