import MovieCard from "./MovieCard";

function MovieGrid(){

    const movieCard = [ {id:1, name:"saalar", collection:700},
                        {id:2, name:"bahubali", collection:1000}];
    
    return(
        <>
            {movieCard.map(movie => (
        <MovieCard key={movie.id} movie={movie} />
      ))}
        </>
    )
}
export default MovieGrid;