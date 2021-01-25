import React, { useState } from "react";
import { Card, Modal, Row, Col } from "antd";

import EmptyImage from "../assets/emptyImage.png";
import LoadingGif from "../assets/loading.gif";
import ReactImageFallback from "react-image-fallback";

const { Meta } = Card;

const MovieCard = ({ movie }) => {
  const [isModalVisible, setIsModalVisible] = useState(false);

  const showModal = () => {
    setIsModalVisible(true);
  };

  const hideModal = () => {
    setIsModalVisible(false);
  };

  return (
    <div>
      <div onClick={() => showModal()}>
        <Card
          hoverable
          style={{ maxHeight: 550 }}
          headStyle={{ width: 300, height: 450 }}
          bodyStyle={{ width: 300, height: 100, overflow: "hidden" }}
          cover={
            <ReactImageFallback
              alt={movie.Title}
              src={movie.Poster}
              fallbackImage={EmptyImage}
              initialImage={LoadingGif}
            />
          }
          className="m-2 overflow-hidden"
        >
          <Meta title={movie.Title} className="mb-2" />
          <Meta description={"Year  : " + movie.Year} />
          <Meta description={"Genre : " + movie.Genre} />
        </Card>
      </div>
      <Modal
        title={movie.Title}
        visible={isModalVisible}
        onCancel={hideModal}
        footer=""
      >
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Title :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Title}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Year :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Year}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Rated :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Rated}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Released :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Released}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Runtime :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Runtime}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Genre :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Genre}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Director :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Director}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Writer :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Writer}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Actors :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Actors}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Plot :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Plot}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Language :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Language}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Country :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Country}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Awards :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Awards}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            IMBD Rating :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.imdbRating}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            IMBD Votes :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.imdbVotes}
          </Col>
        </Row>
        <Row gutter={[8, 12]}>
          <Col flex="auto" className="col-label">
            Type :
          </Col>
          <Col flex="350px" className="col-value">
            {movie.Type}
          </Col>
        </Row>
      </Modal>
    </div>
  );
};

export default MovieCard;
