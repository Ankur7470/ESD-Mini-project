import { useState, useEffect } from "react";
import { apiGet } from "../utils/network";

const useEligiblePlacements = (studentId) => {
  const [placements, setPlacements] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (studentId) {
      const fetchEligiblePlacements = async () => {
        setLoading(true);
        try {
          const data = await apiGet(`/placements/${studentId}`);
          setPlacements(data);
        } catch (err) {
          setError(err);
        } finally {
          setLoading(false);
        }
      };

      fetchEligiblePlacements();
    }
  }, [studentId]);

  return { placements, loading, error };
};

export default useEligiblePlacements;
