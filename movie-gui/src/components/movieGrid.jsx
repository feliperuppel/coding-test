import React from "react";
import MovieCard from "./movieCard";
import { Row, Col, Divider } from "antd";
import NoMovieImage from "../assets/noMovieFound.png";

const MovieGrid = ({ movies }) => {
  const hasMovies = movies.length > 0;
  if (hasMovies) {
    return (
      <div>
        <Divider />
        <Row>
          {movies.map((m) => (
            <Col key={m.imdbID} lg={4} md={12}>
              <MovieCard movie={m}></MovieCard>
            </Col>
          ))}
        </Row>
      </div>
    );
  }
  return (
    <div>
      <Divider />
      <img src={NoMovieImage} alt="No Movie Found =(" />
      <Divider />
      <h2>Oops.. No Movie Found =(</h2>
    </div>
  );
};

export default MovieGrid;
