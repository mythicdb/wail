import React, {Component} from "react";
import RaisedButton from "material-ui/RaisedButton";
import Paper from "material-ui/Paper";
import EditorPopup from "../editor/editor-popup";
import wc from "../../constants/wail-constants";
import {Grid, Row, Column, observeGrid} from 'react-cellblock'

const styles = {
   button: {
      margin: 12,
   },
}

export default class WayBackTab extends Component {
   constructor(props, context) {
      super(props, context)
      this.onClickViewWayback = this.onClickViewWayback.bind(this)
      this.onClickEditWayback = this.onClickEditWayback.bind(this)
   }

   onClickViewWayback(event) {
      console.log('View Wayback')
   }

   onClickEditWayback(event) {
      console.log('Edit Wayback')

   }

   render() {
      return (
         <Paper zdepth={3}>
            <Grid>
               <Row>
                  <Column width="1/2">
                     <RaisedButton
                        label="View Wayback in Browser"
                        labelPosition="before"
                        primary={true}
                        style={styles.button}
                        onMouseDown={this.onClickViewWayback}
                     />
                  </Column>
                  <Column width="1/2">
                     <EditorPopup
                        title={"Editing Wayback Configuration"}
                        buttonLabel={"Edit Wayback Configuration"}
                        codeToLoad={wc.Code.which.WBC}
                        buttonStyle={styles.button}
                     />
                  </Column>
               </Row>
            </Grid>
         </Paper>
      )
   }
}
