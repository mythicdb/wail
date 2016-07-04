import React, {Component} from "react"
import RaisedButton from "material-ui/RaisedButton"
import {Toolbar, ToolbarGroup} from "material-ui/Toolbar"
import {Grid, Row, Column} from "react-cellblock"
import {shell} from 'electron'
import autobind from "autobind-decorator"
import { ipcRenderer, remote } from "electron"
import settings from '../../../settings/settings'
import wailConstants from "../../../constants/wail-constants"
import HeritrixJobList from "./heritrix-joblist"
import HeritrixJobInfo from "./heritrixJobInfo"

const styles = {
  button: {
    margin: 12,
  },
}

const Heritrix = wailConstants.Heritrix

export default class HeritrixTab extends Component {
  constructor (props, context) {
    super(props, context)
    this.state = {
      crawlConfigOpen: false
    }
  }

  @autobind
  onClickNewCrawl (event) {
    console.log('New Crawl')
    // this.setState({ crawlConfigOpen: true })
    ipcRenderer.send("open-newCrawl-window")
  }

  @autobind
  onClickLaunchWebUI (event) {
    console.log(process.platform)
    shell.openExternal(settings.get('heritrix.web_ui'))
  }

  render () {
    return (
      <Grid gutterWidth={20} flexable={true} columnWidth={100}>
        <Row>
          <Column width="1/4">
            <HeritrixJobList />
          </Column>
          <Column width="3/4">
            <HeritrixJobInfo/>
          </Column>
        </Row>
        <Row>
          <Toolbar>
            <ToolbarGroup >
              <RaisedButton
                label="Configure New Crawl"
                labelPosition="before"
                style={styles.button}
                onMouseDown={this.onClickNewCrawl}
              />
            </ToolbarGroup>
            <ToolbarGroup>
              <RaisedButton
                label="Launch Web UI"
                labelPosition="before"
                style={styles.button}
                onMouseDown={this.onClickLaunchWebUI}
              />
            </ToolbarGroup>
          </Toolbar>
        </Row>
      </Grid>
    )
  }
}
