import React, { Component } from "react";

class Hello extends Component {
  componentWillUnmount() {
    alert("Component sắp unmount");
  }
  render() {
    return <h1>Hello Word!!!</h1>
  }
}

export default Hello;
