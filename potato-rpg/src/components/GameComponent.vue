<!-- GameComponent.vue -->

<template>
  <div>
    <h1>Game Page</h1>

    <button @click="fetchEvents">Fetch Events</button>
    <button @click="applyEvent">Apply Event</button>
    <button @click="removeOrc">Remove Orc</button>

    <div v-if="events.length > 0">
      <h2>Events:</h2>
      <ul>
        <li v-for="event in events" :key="event.id">
          {{ event.message }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      events: [],
    };
  },
  methods: {
    fetchEvents() {
      // Implement logic to fetch events from Spring Boot backend
      // Use a library like axios or the Fetch API
    },
    applyEvent() {
      // Implement logic to apply event to Spring Boot backend
    },
    removeOrc() {
      // Implement logic to remove orc in Spring Boot backend
    },
  },
};
</script>

<style>
/* Add your styles here */
</style>