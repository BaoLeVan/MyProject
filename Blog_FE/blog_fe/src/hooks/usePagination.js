import React, { useEffect,useState } from 'react'

const usePagination = (showObject, page) => {
    const [totalPages, setTotalPages] = useState(0);
    const [data, setData] = useState();
    

    const fetchData = (page) => {
        showObject(page).then(res => {
            setData(res.content);
            setTotalPages(res.totalPages)
        })
    }

    useEffect(() => {
        fetchData(page)
    },[page])

    return {data,totalPages,fetchData}
}

export default usePagination
