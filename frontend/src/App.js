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
            </header>
        </div>
    );
}



// function App() {
//     const [message, setMessage] = useState([]);
//     useEffect(() => {
//         fetch("/test")
//             .then((response) => {
//                 return response.json();
//             })
//             .then(function (data) {
//                 setMessage(data);
//             });
//     }, []);
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//           <ul>
//               {message.map((text, index) => <li key={`${index}-${text}`}>{text}</li>)}
//           </ul>
//       </header>
//     </div>
//   );
// }


export default App;
