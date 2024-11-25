import { useState, useEffect } from "react";
import { apiGet } from "../utils/network";

const useApplicationStatus = (studentId, placementId) => {
  const [status, setStatus] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (studentId && placementId) {
      const fetchApplicationStatus = async () => {
        setLoading(true);
        try {
          const response = await apiGet(`/placements/status/${studentId}/${placementId}`);
          setStatus(response);
        } catch (err) {
          setError(err);
        } finally {
          setLoading(false);
        }
      };

      fetchApplicationStatus();
    }
  }, [studentId, placementId]);

  return { status, loading, error };
};

export default useApplicationStatus;
