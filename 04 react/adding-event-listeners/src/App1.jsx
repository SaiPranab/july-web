import CustomButton from './CustomButton'

export default function App1() {
    // function handleCLick(e) {
    //     console.log("Button Clicked")
    //     console.log('e', e)
    // }

    function sayHii(e) {
        console.log(2)
        console.log('e', e)
    }

    function sayHello() {
        console.log("Heloooooooooooooo")
    }

    return (
        <>
            {/* <button onClick={handleCLick}>Click Me!!!</button> */}

            {/* <button onClick={function (e) {
                    console.log("Button Clicked")
                    console.log('e', e)
                }}>Click Me!!!</button> */}


            <button onClick={(e) => sayHii(e)}>Click Me!!!</button>
            <br /> <br />
            
            <CustomButton onClick={sayHello} />
        </>
    )
}
