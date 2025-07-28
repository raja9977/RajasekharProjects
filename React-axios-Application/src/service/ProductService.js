


import axios from "axios";

export const saveProduct = async (jsonPayload) => {
    try {
        const response = await axios.post("http://localhost:8754/api/v1/save", jsonPayload);
        console.log("Product saved:", response);
        alert("Product saved successfully");
        return response.data;
    } catch (error) {
        console.error("Error saving product:", error);
        throw error;
    }
};

export const getProducts = async () => {
    try {
        const response = await axios.get("http://localhost:6789/api/v1/products");
        return response.data;
    } catch (error) {
        console.error("Error fetching products:", error);
        return [];
    }
};

export const deleteProduct = async (id) => {
    try {
        const response = await axios.delete(`http://localhost:6789/api/v1/deletebyid/${id}`);
        return response;
    } catch (error) {
        console.error("Error deleting product:", error);
        throw error;
    }
};

export const editProduct = async (productId, updatedProductData) => {
    try {
        const response = await axios.put(`http://localhost:6789/api/v1/editproduct/${productId}`, updatedProductData);
        return response.data;
    } catch (error) {
        console.error("Error updating product:", error);
        throw error;
    }
};
