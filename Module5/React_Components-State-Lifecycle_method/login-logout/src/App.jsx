import React, {useState} from "react";
import LoginForm from "./LoginForm";
import Welcome from "./Welcome";

function App() {
    const [isLoggedIn, setLoggedIn] = useState(false);

    return (
    <div className="container mt-5">
            {!isLoggedIn ? (
                <LoginForm onLogin={()=> setLoggedIn(true)} />
            ): (
                <Welcome onLogout={()=> setLoggedIn(false)} />
            )
            }
        </div>
    );
}
export default App;



