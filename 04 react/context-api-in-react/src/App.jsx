import './App.css'
import A from './components/A'
import D from './components/D'
import MessageProvider, { MessageContext } from './store/MessageContext'

function App() {
  return (
    <>

      <MessageProvider>
        <A />
        <D />
      </MessageProvider>

      {/* <D /> */}
    </>
  )
}

export default App
