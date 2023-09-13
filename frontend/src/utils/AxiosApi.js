import axios from "axios";
import { URI } from "./config";

const RestAPI = axios.create({
  baseURL: URI.BASE_URL,
  headers: {
    "Content-Type": "application/json",
  },
  timeout:1000,
  withCredentials: true,
  AllowOrigins: ["http://13.124.113.135:8080", "http://localhost:3000"],
});

export default RestAPI;
