import React, { Component } from "react";

class Welcome extends Component {
  componentWillUnmount() {
    console.log("Welcome component is being unmounted (logout).");
  }

  render() {
    return (
      <div className="text-center">
        <h2>Welcome back!</h2>
        <button className="btn btn-danger mt-3" onClick={this.props.onLogout}>
          Logout
        </button>
      </div>
    );
  }
}

export default Welcome;
