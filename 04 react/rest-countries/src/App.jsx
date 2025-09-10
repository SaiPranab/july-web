import Header from './components/Header.jsx'
import './App.css'
import SearchBar from './components/SearchBar.jsx'
import SelectMenu from './components/SelectMenu.jsx'
import CountriesList from './components/CountriesList.jsx'

function App() {
  return (
    <>
      <Header />
      <main>
        <div className='search-filter-container'>
          <SearchBar />
          <SelectMenu />
        </div>

        <CountriesList />
      </main>
    </>
  )
}

export default App
