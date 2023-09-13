import React, { useEffect, useState } from "react";
import { TargetListTemplate } from "./templates/TargetListTemplate";
import { getAllTargetInfo } from "../services/TargetService";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";

export const TargetListPage = () => {
  var [loading, setLoading] = useState(true);
  var [data, setData] = useState({});

  const fetchData = async () => {
    const targets = await getAllTargetInfo();
    data["targetList"] = targets;
  };

  useEffect(() => {
    setLoading(true);
    const loadData = async () => {
      fetchData();
    };

    loadData();
    setLoading(false);
  }, []);

  return (
    <>
      {loading ? (
        <div>로딩중</div>
      ) : (
        <BasicFrame content={() => <TargetListTemplate data={data} />} />
      )}
    </>
  );
};
