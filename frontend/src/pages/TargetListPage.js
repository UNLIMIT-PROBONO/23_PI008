import React, { useEffect, useState } from "react";
import { TargetListTemplate } from "./templates/TargetListTemplate";
import { getAllTargetInfo } from "../services/TargetService";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";
import { useNavigate } from "react-router";

export const TargetListPage = () => {
  const [loading, setLoading] = useState(true);
  const [targetList, setTargetList] = useState([]);
  const router = useNavigate();

  const fetchTargetList = async () => {
    const result = await getAllTargetInfo();
    if (result) setTargetList(result);
  };

  const onClickRow = (index) => {
    router(`${index}`);
  };

  useEffect(() => {
    setLoading(true);
    const fetchData = async () => {
      fetchTargetList();
    };

    fetchData();
    setLoading(false);
  }, []);

  return (
    <>
      {loading ? (
        <div>로딩중</div>
      ) : (
        <BasicFrame
          content={() => (
            <TargetListTemplate
              targetList={targetList}
              onClickRow={onClickRow}
            />
          )}
        />
      )}
    </>
  );
};
