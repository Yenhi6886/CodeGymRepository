import React from "react"; // import thu vie react
import ReactDOM from "react-dom/client";

function App() {
    return (
        <div>
            <h1>Hello you!</h1>
        </div>
    );
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App />);