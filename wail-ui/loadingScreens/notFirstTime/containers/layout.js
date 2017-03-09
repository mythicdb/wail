import React, { PropTypes } from 'react'
import { namedPure } from '../../../util/recomposeHelpers'
import Header from '../../shared/header'
import { Card, CardHeader, CardMedia } from 'material-ui/Card'
import ProgressSteps from '../components/progress/progressSteps'
import ProgressMessage from '../components/progress/progressMessage'

const enhance = namedPure('Layout')

const Layout = () => (
  <div>
    <Header title='WAIL Is Loading' />
    <div style={{transform: 'translateY(10px)'}}>
      <div className='wail-container'>
        <Card style={{minHeight: '350px'}}>
          <CardHeader
            title='Loading Steps'
          />
          <CardMedia style={{minHeight: '250px'}}>
            <ProgressSteps />
            <ProgressMessage />
          </CardMedia>
        </Card>
      </div>
    </div>
  </div>
)

export default enhance(Layout)