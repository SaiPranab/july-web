import { useRouteError } from "react-router"

export default function Errorpage() {
    const error = useRouteError()
    console.log(error)

    return (
        <>
            <h1>Oops! Something went wrong {error.status}</h1>
            <p>{error.statusText}</p>
            <p>{error.data}</p>
        </>
    )
}