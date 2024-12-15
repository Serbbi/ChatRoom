import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Home from "./Home.jsx";

function App() {
    const [username, setUsername] = useState('');
    const [loggedIn, setLoggedIn] = useState(false);
    function handleClick() {
        fetch('http://localhost:8080/user', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name: username})
        })
            .then(r => r.json())
            .then(data => {
                console.log(data);
                localStorage.setItem("username", data.name);
                localStorage.setItem("userid", data.id);
                setLoggedIn(true);
            })
            .catch(e => console.error(e));
     }

        function handleInputChange(e) {
            setUsername(e.target.value)
        }

  return (
    <>
        {
            loggedIn ?
                <Home username={username}/> :
                <>
                    <input type="text" placeholder={"Username"} onChange={handleInputChange}/>
                    <button onClick={handleClick}>Login</button>
                </>
        }
    </>
  )
}

export default App
