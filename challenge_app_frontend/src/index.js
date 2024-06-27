import React from 'react'; //for creating and defining React component
import ReactDOM from 'react-dom/client'; // ReactDOM is a client API which is used for rendering React components to the DOM (Document Object Model)
import './index.css'; // importing CSS files
import App from './App'; // Our component getting imported to render
import reportWebVitals from './reportWebVitals'; // to monitor web performance metrics

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
