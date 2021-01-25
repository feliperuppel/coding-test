import axios from "axios";

const URL = "http://localhost:3001/Movies";

export const fetchMovies = async () => {
  const { data } = await axios.get(URL);
  return data;
};
