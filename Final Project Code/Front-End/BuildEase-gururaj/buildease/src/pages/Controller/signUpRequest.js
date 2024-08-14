import React, { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
    const [data, setData] = useState("");

    useEffect(() => {
        axios.get("http://localhost:8081/swagger-ui/index.html#/signIn")
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("There was an error!", error);
            });
    }, []);

    return (
        <div className="App">
            <h1>{data}</h1>
        </div>
    );
}

export default App;
