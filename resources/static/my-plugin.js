Gerrit.install(plugin => {
  plugin.on('change-view-integration', context => {
    const el = document.createElement('div');
    el.style.marginTop = '1em';
    el.innerHTML = `
      <h4>🧪 Select Tests to Run</h4>
      <label><input type="checkbox" value="test1"> test1</label><br>
      <label><input type="checkbox" value="test2"> test2</label><br>
      <label><input type="checkbox" value="test3"> test3</label><br>
      <button id="run-tests">Run Tests</button>
      <div id="result" style="margin-top:0.5em;"></div>
    `;

    el.querySelector('#run-tests').addEventListener('click', () => {
      const tests = [...el.querySelectorAll('input:checked')].map(cb => cb.value);
      const payload = {
        commitId: context.change.current_revision,
        tests: tests
      };

      fetch(`${plugin.url()}/schedule`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(payload)
      })
      .then(r => r.text())
      .then(msg => {
        el.querySelector('#result').innerHTML = `<span style="color:green">✅ Sent</span>`;
      })
      .catch(err => {
        el.querySelector('#result').innerHTML = `<span style="color:red">❌ Error</span>`;
      });
    });

    context.container.appendChild(el);
  });
});
