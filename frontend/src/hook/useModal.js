import { useCallback, useState } from "react";

export const useModal = (initValue) => {
  const [open, setOpen] = useState(initValue);

  const openModal = () => {
    setOpen(true);
  };

  const closeModal = () => {
    setOpen(false);
  };

  return [ open, openModal, closeModal ];
};
