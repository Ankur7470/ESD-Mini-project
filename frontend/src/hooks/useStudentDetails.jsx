import { useState, useEffect } from "react";
import { apiGet } from "../utils/network";

const useStudentDetails = (email) => {
  const [studentDetails, setStudentDetails] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchStudentDetails = async () => {
      setLoading(true);
      try {
        const data = await apiGet(`/details/${email}`);
        setStudentDetails(data);
      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    };

    fetchStudentDetails();
  }, [email]);

  return { studentDetails, loading, error };
};

export default useStudentDetails;
