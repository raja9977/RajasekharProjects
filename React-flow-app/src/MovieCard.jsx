function MovieCard({movie}){

    return(
        <>
        <h1>Movies</h1>
        <p>movie name:{movie.name}</p>
        <p>movie collection: {movie.collection}</p>
        </>
    )
}
export default MovieCard;