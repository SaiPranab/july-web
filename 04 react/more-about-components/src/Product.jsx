export default function Product({ brand, price, ...extras }) {
    // console.log('props', props)

    // const brand = props.brand
    // const price = props.price

    // const {brand, price, ...extras} = props
    console.log(brand, price, extras)

    return (
        <>
            <h1>{brand} Shoes</h1>
            <h2>{price}</h2>
        </>
    )
}

// export default Product