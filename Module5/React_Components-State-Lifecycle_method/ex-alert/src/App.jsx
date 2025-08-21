import React from "react";
import PropTypes from "prop-types";

// Functional Component
function Alert({ text }) {
  return (
    <div className="alert alert-warning" role="alert">
      {text}
    </div>
  );
}

// Kiểm tra kiểu dữ liệu của props
Alert.propTypes = {
  text: PropTypes.string.isRequired,
};

// App component sử dụng Alert
function App() {
  return (
    <div>
      <Alert text="Cảnh báo! Tài nguyên bạn vừa truy cập không tồn tại." />
    </div>
  );
}

export default App;
