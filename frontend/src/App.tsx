import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Header from "./components/Header";
import Form from "./components/Form";
import Gallery from "./components/Gallery";
import { Link } from "react-router-dom";
import MainPage from "./routes/MainPage";
import EditPage from "./routes/EditPage";



function App() {
  return (
      <div>
          <BrowserRouter>
              <Routes>
                  <Route path="/" element={<MainPage />} />
                  <Route path="/:id" element={<EditPage />} />
              </Routes>
          </BrowserRouter>
      </div>
  );
}

export default App;
