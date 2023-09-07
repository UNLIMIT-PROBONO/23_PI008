import axios from "axios";
import { URI } from "./config";

const RestAPI = axios.create({
  baseURL: URI.BASE_URL,
  headers: {
    "Content-Type": "application/json",
  },
  timeout:1000,
});

export default RestAPI;
