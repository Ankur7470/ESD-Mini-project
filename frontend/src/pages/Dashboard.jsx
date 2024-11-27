import { useNavigate, useLocation } from "react-router-dom";
import Sidebar from "../components/Sidebar";
import PlacementList from "../components/PlacementList";
import Loading from "../components/Loading";
import Error from "../components/Error";
import useStudentDetails from "../hooks/useStudentDetails";
import useEligiblePlacements from "../hooks/useEligiblePlacements";
import useAppliedPlacements from "../hooks/useAppliedPlacements"; 

const Dashboard = () => {
  const location = useLocation();
  const email = location.state;
  const navigate = useNavigate();

  const { studentDetails, loading: studentLoading, error: studentError } = useStudentDetails(email);
  const { placements, loading: placementsLoading, error: placementsError } = useEligiblePlacements(
    studentDetails?.studentId
  );

  const { appliedPlacements, loading: appliedLoading, error: appliedError } = useAppliedPlacements(
    studentDetails?.studentId
  ); 

  const handleLogout = () => {
    localStorage.removeItem("jwtToken");
    navigate("/");
  };

  if (studentLoading || placementsLoading || appliedLoading) return <Loading message="Dashboard" />;
  if (studentError || placementsError || appliedError)
    return <Error error={studentError || placementsError} onRetry={() => {window.location.reload()}} />;

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-100 to-indigo-200 flex">
      <Sidebar studentDetails={studentDetails} onLogout={handleLogout} />
      <div className="ml-[25%] w-[75%] pl-10 pr-6 pt-8 pb-8">
        <h1 className="text-3xl font-bold text-indigo-800 mb-8 text-center">Eligible Placement Opportunities</h1>
        <PlacementList placements={placements} appliedPlacements={appliedPlacements} studentDetails={studentDetails} />
      </div>
    </div>
  );
};

export default Dashboard;
