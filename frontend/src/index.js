import React from "react";
import ReactDOM from "react-dom/client";
import reportWebVitals from "./reportWebVitals";
import { SignUpPage } from "./pages/SignUpPage";
import { LoginPage } from "./pages/LoginPage";
import {MainHomePage} from  "./pages/MainHomePage";
import { Route, Routes } from "react-router";
import { BrowserRouter } from "react-router-dom";
import { TargetListPage } from "./pages/TargetListPage";
import { TargetDetailPage } from './pages/TargetDetailPage';
import { ScheduleCalendarPage } from './pages/ScheduleCalendarPage';
import { MyPage } from "./pages/MyPage";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<LoginPage />} />
      <Route path="/signup" element={<SignUpPage />} />
      <Route path="/main" element={<MainHomePage />} />
      <Route path="/target-list" element={<TargetListPage />} />
      <Route path="/target/:id" element={<TargetDetailPage />} />
      <Route path="/schedule" element={<ScheduleCalendarPage />} />
      <Route path="/my-page" element={<MyPage />} />
    </Routes>
  </BrowserRouter>
);

reportWebVitals();
