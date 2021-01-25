import React, { useEffect } from "react";
import { fetchMovies } from "../api/movieApi";
import MovieGrid from "../components/movieGrid";
import "./home.css";
import { Form, Input, Button, Col, Row, Divider } from "antd";

const Home = () => {
  const [movies, setMovies] = React.useState([]);
  const [allMovies, setAllMovies] = React.useState([]);

  useEffect(() => {
    loadFullMovieList();
  }, []);

  const loadFullMovieList = async () => {
    const data = await fetchMovies();
    setMovies(data);
    setAllMovies(data);
    return data;
  };

  const onFinish = (values) => {
    let filteredMovies = allMovies;

    const countryFilter = form.getFieldValue("filter-country");
    const writerFilter = form.getFieldValue("filter-writer");
    const genreFilter = form.getFieldValue("filter-genre");
    if (countryFilter) {
      filteredMovies = filteredMovies.filter((movie) =>
        movie.Country.toLowerCase().includes(countryFilter.toLowerCase())
      );
    }
    if (writerFilter) {
      filteredMovies = filteredMovies.filter((movie) =>
        movie.Writer.toLowerCase().includes(writerFilter.toLowerCase())
      );
    }
    if (genreFilter) {
      filteredMovies = filteredMovies.filter((movie) =>
        movie.Genre.toLowerCase().includes(genreFilter.toLowerCase())
      );
    }
    setMovies(filteredMovies);
  };

  const [form] = Form.useForm();

  const onReset = () => {
    form.resetFields();
    form.submit();
  };

  return (
    <div className="wrapper">
      <header>Great Movies</header>
      <main className="text-center">
        <Divider orientation="center" plain>
          Filters
        </Divider>
        <Form form={form} name="control-hooks" onFinish={onFinish}>
          <Row>
            <Col flex={1} className="m-2">
              <Form.Item name="filter-country" label="Country">
                <Input />
              </Form.Item>
            </Col>
            <Col flex={1} className="m-2">
              <Form.Item name="filter-writer" label="Writer">
                <Input />
              </Form.Item>
            </Col>
            <Col flex={1} className="m-2">
              <Form.Item name="filter-genre" label="Genre">
                <Input />
              </Form.Item>
            </Col>
          </Row>
          <Form.Item>
            <Button type="submit" onClick={onFinish} className="mr-2">
              Filter
            </Button>
            <Button type="button" onClick={onReset} className="ml-2">
              Clear Filters
            </Button>
          </Form.Item>
        </Form>
        <MovieGrid movies={movies}></MovieGrid>
      </main>
      <footer>
        <div>
          {" "}
          © 2021 - Built with React, by{" "}
          <a href="https://feliperuppel.com" target="_blank" rel="noreferrer">
            Felipe Ruppel
          </a>
        </div>
      </footer>
    </div>
  );
};

export default Home;
