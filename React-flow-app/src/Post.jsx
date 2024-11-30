import PostTitle from "./assets/PostTitle";
import PostBody from "./PostBody";

function Post({title,body}){
    return(
        <>
        <PostTitle title1= {title}/>
        <PostBody  body1= {body}/>
        </>
    )
}
export default Post;