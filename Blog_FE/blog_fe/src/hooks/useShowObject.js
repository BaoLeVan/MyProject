import React, { useEffect, useState } from 'react'

const useShowObject = (showObject) => {
    const [data, setData] = useState();
    useEffect(() => {
        showObject().then(res => {
            setData(res)
        })
    }, [showObject])

    return { data }
}

export default useShowObject
