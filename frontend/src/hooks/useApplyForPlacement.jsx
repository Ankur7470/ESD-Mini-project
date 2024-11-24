import { useState } from "react";
import { apiPost } from "../utils/network";

const useApplyForPlacement = () => {
    const [isApplied, setIsApplied] = useState(false);
  
    const applyForPlacement = async ({ placementId, studentId, cvFile, about, closeModal }) => {
      const formData = new FormData();
      formData.append('placementId', placementId);
      formData.append('studentId', studentId);
      formData.append('cvFile', cvFile);
      formData.append('about', about);
  
      try {
        const response = await apiPost('/placements/apply', formData);
        if (response.status === 200) {
          alert('Application submitted successfully!');
          setIsApplied(true);
          closeModal();
        } else {
          alert('Error submitting application');
        }
      } catch (error) {
        console.error('Error:', error);
        alert('Error submitting application');
      }
    };
  
    return { isApplied, applyForPlacement };
  };
  
  export default useApplyForPlacement;