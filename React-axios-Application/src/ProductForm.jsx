// 





// import { useRef } from "react";
// import { saveProduct } from "./productservie";


// function ProductForm() {
//     // useRef for each form input field 
//     const nameRef = useRef();
//     const quantityRef = useRef();
//     const priceRef = useRef();
//     const categoryRef = useRef();
//     const imageRef = useRef();

//     const handleSubmit = async (e) => {
//         e.preventDefault();
        
//         const jsonPayload = {
//             name: nameRef.current.value,
//             quantity: parseInt(quantityRef.current.value, 10),
//             price: parseFloat(priceRef.current.value),
//             category: categoryRef.current.value,
//             image: imageRef.current.files[0].name
//         }

//         saveProduct(jsonPayload);
//     }

//     return (
//         <div className="container mt-5">
//             <h2 className="text-center mb-4">Add New Product</h2>
//             <form onSubmit={handleSubmit} encType="multipart/form-data">
//                 <div className="form-group mb-3">
//                     <label htmlFor="name">Product Name:</label>
//                     <input
//                         type="text"
//                         id="name"
//                         className="form-control"
//                         ref={nameRef}
//                         required
//                     />
//                 </div>

//                 <div className="form-group mb-3">
//                     <label htmlFor="quantity">Product Quantity:</label>
//                     <input
//                         type="number"
//                         id="quantity"
//                         className="form-control"
//                         ref={quantityRef}
//                         required
//                     />
//                 </div>

//                 <div className="form-group mb-3">
//                     <label htmlFor="price">Product Price:</label>
//                     <input
//                         type="number"
//                         id="price"
//                         className="form-control"
//                         ref={priceRef}
//                         required
//                     />
//                 </div>

//                 <div className="form-group mb-3">
//                     <label htmlFor="category">Product Category:</label>
//                     <input
//                         type="text"
//                         id="category"
//                         className="form-control"
//                         ref={categoryRef}
//                         required
//                     />
//                 </div>

//                 <div className="form-group mb-3">
//                     <label htmlFor="image">Product Image:</label>
//                     <input
//                         type="file"
//                         id="image"
//                         className="form-control"
//                         ref={imageRef}
//                         required
//                     />
//                 </div>

//                 <button type="submit" className="btn btn-primary w-100">Submit</button>
//             </form>
//         </div>
//     );
// }

// export default ProductForm;c

import { useRef } from "react";
import { saveProduct } from "./service/ProductService";

function ProductForm() {
    const nameRef = useRef();
    const quantityRef = useRef();
    const priceRef = useRef();
    const categoryRef = useRef();
    const imageRef = useRef();

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        const jsonPayload = {
            name: nameRef.current.value,
            quantity: parseInt(quantityRef.current.value, 10),
            price: parseFloat(priceRef.current.value),
            category: categoryRef.current.value,
            image: imageRef.current.files[0]?.name || ""
        };

        await saveProduct(jsonPayload);
    };

    return (
        <div className="container mt-5">
            <h2 className="text-center mb-4">Add New Product</h2>
            <form onSubmit={handleSubmit} encType="multipart/form-data">
                <div className="form-group mb-3">
                    <label htmlFor="name">Product Name:</label>
                    <input type="text" id="name" className="form-control" ref={nameRef} required />
                </div>
                <div className="form-group mb-3">
                    <label htmlFor="quantity">Product Quantity:</label>
                    <input type="number" id="quantity" className="form-control" ref={quantityRef} required />
                </div>
                <div className="form-group mb-3">
                    <label htmlFor="price">Product Price:</label>
                    <input type="number" id="price" className="form-control" ref={priceRef} required />
                </div>
                <div className="form-group mb-3">
                    <label htmlFor="category">Product Category:</label>
                    <input type="text" id="category" className="form-control" ref={categoryRef} required />
                </div>
                <div className="form-group mb-3">
                    <label htmlFor="image">Product Image:</label>
                    <input type="file" id="image" className="form-control" ref={imageRef} />
                </div>
                <button type="submit" className="btn btn-primary w-100">Submit</button>
            </form>
        </div>
    );
}

export default ProductForm;
