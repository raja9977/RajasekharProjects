import React from 'react';
import ProductForm from './ProductForm';
import ProductTable from './ProductTable';
import './App.css'; // Importing App.css for custom styles

function App() {
  return (
    <div className="app-container">
      <h2 className="page-title">Product Management</h2>
      <div className="product-form">
        <ProductForm />
      </div>
      <div className="product-table-container">
        <ProductTable />
      </div>
    </div>
  );
}

export default App;