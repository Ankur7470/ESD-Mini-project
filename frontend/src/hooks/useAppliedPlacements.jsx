import { useState, useEffect } from "react";
import { apiGet } from "../utils/network";

const useAppliedPlacements = (studentId) => {
  const [appliedPlacements, setAppliedPlacements] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (studentId) {
      const fetchAppliedPlacements = async () => {
        setLoading(true);
        try {
          const data = await apiGet(`/placements/applied/${studentId}`);
          setAppliedPlacements(data);
        } catch (err) {
          setError(err);
        } finally {
          setLoading(false);
        }
      };

      fetchAppliedPlacements();
    }
  }, [studentId]);

  return { appliedPlacements, loading, error };
};

export default useAppliedPlacements;
