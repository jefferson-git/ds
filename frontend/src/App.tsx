import Header from "./components/Header";
import SelesCard from "./components/SelesCard/SelesCard";
import "./index.css";

function App() {
  return (
    <>
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SelesCard />
          </div>
        </section>
      </main>
    </>
  );
}

export default App;
