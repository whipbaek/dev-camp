import logo from './logo.svg';
import './App.css';
import React, {useState, useEffect} from "react";
import axios, {Axios} from "axios";

function App() {
    const [str, setStr] = useState("");

    useEffect(()=>{
        axios.get("/api/test")
            .then((response) =>{
                console.log(response.data);
                setStr(response.data);
            })
            .catch(() =>{
                alert("fail");
            })
    }, []);

    return (
        <div className="App">
            <header className="App-header">
                <h1>Data : {str}</h1>
                ID
                <form onSubmit={{}}>
                    <input
                        type="text"
                        name="email"
                    />
                </form>
                PW
                <form onSubmit={{}}>
                    <input
                        type="text"
                        name="email"
                    />
                </form>
                <button type="submit">로그인</button>
                <button type="submit">회원가입</button>
            </header>



        </div>

    );
}

export default App;
