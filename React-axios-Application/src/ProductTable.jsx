import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { deleteProduct, editProduct, getProducts } from "./service/ProductService";

function ProductTable() {
    const [products, setProducts] = useState([]);
    const [isEditing, setIsEditing] = useState(false);
    const [currentProduct, setCurrentProduct] = useState(null);
    const [editData, setEditData] = useState({
        name: "",
        quantity: "",
        price: "",
        category: "",
    });

    const fetchProducts = async () => {
        const data = await getProducts();
        setProducts(data);
    };

    const handleEditClick = (product) => {
        setIsEditing(true);
        setCurrentProduct(product);
        setEditData({
            name: product.name,
            quantity: product.quantity,
            price: product.price,
            category: product.category,
        });
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setEditData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    const handleSave = async () => {
        try {
            await editProduct(currentProduct.id, editData);
            fetchProducts();
            setIsEditing(false);
            setCurrentProduct(null);
            alert("Product updated successfully");
        } catch (error) {
            alert("Error updating product");
        }
    };

    const handleDelete = async (productId) => {
        if (window.confirm("Are you sure you want to delete this product?")) {
            try {
                await deleteProduct(productId);
                alert("Product deleted successfully.");
                fetchProducts();
            } catch (error) {
                alert("Error deleting product.");
            }
        }
    };

    return (
        <>
            <div className="container py-5 bg-light">
                <button className="btn btn-primary mb-4" onClick={fetchProducts}>Fetch Products</button>
                <h1 className="text-center mb-4">Product Table</h1>
                <table className="table table-striped table-bordered table-hover">
                    <thead className="table-dark">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Category</th>
                            <th>Image</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {products.map((product) => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.name}</td>
                                <td>{product.quantity}</td>
                                <td>{product.price}</td>
                                <td>{product.category}</td>
                                <td>
                                    <img
                                        src={`./Images/${product.image}`}
                                        alt={product.name}
                                        width="150"
                                        height="120"
                                        className="img-thumbnail"
                                    />
                                </td>
                                <td>
                                    <button className="btn btn-success btn-sm mr-2" onClick={() => handleEditClick(product)}>Edit</button>
                                    <button className="btn btn-danger btn-sm" onClick={() => handleDelete(product.id)}>Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>

                {isEditing && (
                    <div className="modal d-block bg-white p-4 rounded shadow-lg">
                        <h2 className="text-center">Edit Product</h2>
                        <div className="form-group">
                            <label>Name:</label>
                            <input type="text" name="name" className="form-control" value={editData.name} onChange={handleInputChange} />
                        </div>
                        <div className="form-group">
                            <label>Quantity:</label>
                            <input type="number" name="quantity" className="form-control" value={editData.quantity} onChange={handleInputChange} />
                        </div>
                        <div className="form-group">
                            <label>Price:</label>
                            <input type="number" name="price" className="form-control" value={editData.price} onChange={handleInputChange} />
                        </div>
                        <div className="form-group">
                            <label>Category:</label>
                            <input type="text" name="category" className="form-control" value={editData.category} onChange={handleInputChange} />
                        </div>
                        <div className="d-flex justify-content-between mt-4">
                            <button className="btn btn-success" onClick={handleSave}>Save</button>
                            <button className="btn btn-secondary" onClick={() => setIsEditing(false)}>Cancel</button>
                        </div>
                    </div>
                )}
            </div>
        </>
    );
}

export default ProductTable;
