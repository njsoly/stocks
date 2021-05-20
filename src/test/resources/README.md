- What are these things -
---
- fullOrderHistory.sample.json
  - JSON that holds all the orders.
  - the LichAmnesia grab_robinhood_records.py file exports orders.json that isn't really a JSON, because the top-level object is an array of python objects, which isn't JSON-compliant.  Thankfully, it's not that far away.  
    My edits to that script prepend that output with `{ orders: ` , and appends ` }` after they're done, making the file a valid JSON object, with only one key-value pair, where the value is our array of all the orders.
      - Also, I edited the script to change `None` -> `null`, `True` -> `true`, etc.
  - FullOrderHistory.kt will attempt to represent the structure of this file as a whole.
  - This sample file only holds two orders.


- rawRobinhoodOrder.sample.json
  - one order in history.
  - one of the items in the overall array held in FullOrderHistory.
  - will be Kotlinized by RawRobinhoodOrder.kt
  - this will be a filled order, which I consider the most standard state, vs. filled, queued, etc.
    
- order-queued.sample.json
  - an order in state=queued; it hasn't been filled yet.

- order-cancelled.sample.json
  - a cancelled order
    
- order-rejected.sample.json
    - will I have any of these?
    - sometimes Robinhood rejects orders, but I'm not sure they get exported to these files.

- executedNotionalExample:
  * one of the nested objects within a RawRobinhoodOrder.
    
