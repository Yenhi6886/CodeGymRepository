import { Component } from "react";

class Greeting extends Component {
    render() {
        return <h1>Hello {this.props.value}</h1>
    }
}

class App extends Component {
    render() {
        return <Greeting value="Alice" />
    }
} 

export default App;