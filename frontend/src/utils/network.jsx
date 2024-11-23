import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

const getAuthToken = () => {
  const token = localStorage.getItem("jwtToken");
  if (!token) throw new Error("Missing or invalid token. Please log in again.");
  return JSON.parse(token);
};

export const apiGet = async (endpoint) => {
  const token = getAuthToken();
  try {
    const response = await axios.get(`${API_BASE_URL}${endpoint}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    return response.data;
  } catch (err) {
    throw err.response?.data?.message || "Failed to fetch data.";
  }
};
