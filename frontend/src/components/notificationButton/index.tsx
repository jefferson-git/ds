import axios from "axios";
import icon from "../../assets/img/notification-icon.svg";
import { BASE_URL } from "../../utils/request";

import "./styles.css";

type Props = {
  saleId: number;
};

function handelClick(id: number) {
  axios(`${BASE_URL}/sale/${id}/notification`).then((response) => {
    console.log("foi blz");
  });
}

function NotificationButton({ saleId }: Props) {
  return (
    <>
      <div className="dsmeta-red-btn" onClick={() => handelClick(saleId)}>
        <img src={icon} alt="Notificar" />
      </div>
    </>
  );
}

export default NotificationButton;
