import { useContext, useEffect, useState } from "react"
import SearchBar from './SearchBar'
import SelectMenu from './SelectMenu'
import CountriesList from './CountriesList'
import { ThemeContext } from "../store/ThemeContext"
import useWindowSize from "../hooks/useWindowSize"


export default function Home() {
    const [query, setQuery] = useState('')

    const { isDark } = useContext(ThemeContext);

    // const [width, setWidth] = useState(window.innerWidth)
    // const [height, setHeight] = useState(window.innerHeight)
    // const [windowSize, setWindowSize] = useState({
    //     width: window.innerWidth,
    //     height: window.innerHeight
    // })
    // useEffect(() => {
    //     window.addEventListener('resize', () => {
    //         // console.log(window.innerWidth, 'X', window.innerHeight)
    //         // setWidth(window.innerWidth)
    //         // setHeight(window.innerHeight)
    //         setWindowSize({
    //             width: window.innerWidth,
    //             height: window.innerHeight
    //         })
    //     })
    // }, [])

    const windowSize = useWindowSize()

    return (
        <>
            {/* <h1 style={{ textAlign: 'center' }}>{`${window.innerWidth} X ${window.innerHeight}`}</h1> */}
            {/* <h1 style={{ textAlign: 'center' }}>{`${width} X ${height}`}</h1> */}
            <h1 style={{ textAlign: 'center' }}>{`${windowSize.width} X ${windowSize.height}`}</h1>
            <main className={`${isDark ? "dark" : ""}`}>
                <div className='search-filter-container'>
                    <SearchBar setQuery={setQuery} />
                    <SelectMenu setQuery={setQuery} />
                </div>

                <CountriesList query={query} />
            </main>
        </>
    )
}